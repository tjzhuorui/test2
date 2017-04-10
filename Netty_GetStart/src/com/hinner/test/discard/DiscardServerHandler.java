package com.hinner.test.discard;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {// {1}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)// {2}
			throws Exception {
		// Discard the received data silently.
		// ((ByteBuf) msg).release();// {3}
		// ReferenceCountUtil.release(msg);
		ByteBuf bb = (ByteBuf) msg;
		try {
			// while (bb.isReadable()) {
			// System.out.print((char) bb.readByte());
			// }
			// System.out.println();
			System.out.println(bb.toString(CharsetUtil.UTF_8));
			ctx.write(bb);
			ctx.flush();

		} finally {
			// ReferenceCountUtil.release(bb);
		}

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("123123123");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();// {4}
		ctx.close();
	}

}
