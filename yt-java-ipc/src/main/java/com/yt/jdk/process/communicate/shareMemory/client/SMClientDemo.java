package com.yt.jdk.process.communicate.shareMemory.client;

import com.yt.jdk.process.communicate.shareMemory.server.SMServerDemo;

import java.io.File;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * Created by yantong on 2019/3/30.
 */
public class SMClientDemo {

    public static void main( String[] args ) throws Throwable {
        File f = new File(SMServerDemo.FILE_NAME );
        FileChannel channel = FileChannel.open( f.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE );

        MappedByteBuffer b = channel.map( FileChannel.MapMode.READ_WRITE, 0, 4096 );
        CharBuffer charBuf = b.asCharBuffer();

        // Prints 'Hello server'
        char c;
        while( ( c = charBuf.get() ) != 0 ) {
            System.out.print( c );
        }
        System.out.println();

        charBuf.put( 0, '\0' );
    }
}
