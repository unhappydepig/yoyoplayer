package com.hadeslee.audiotag.audio.mp3;

import com.hadeslee.audiotag.audio.generic.AudioFileWriter;
import com.hadeslee.audiotag.audio.exceptions.CannotWriteException;
import com.hadeslee.audiotag.audio.AudioFile;
import com.hadeslee.audiotag.tag.Tag;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Write Mp3 Info (retrofitted to entagged ,done differently to entagged which is why some methods throw RuntimeException)
 * because done elsewhere
 */
public class MP3FileWriter extends AudioFileWriter
{
    public void deleteTag(AudioFile f) throws CannotWriteException
    {
        //Because audio file is an instanceof MP3File this directs it to save
        //taking into account if the tag has been sent to null in which case it will be deleted
        f.commit();
    }

    public void writeFile(AudioFile f) throws CannotWriteException
    {
        //Because audio file is an instanceof MP3File this directs it to save
        f.commit();
    }

    protected void writeTag(Tag tag, RandomAccessFile raf, RandomAccessFile rafTemp) throws CannotWriteException, IOException
    {
         throw new RuntimeException("MP3FileReaderwriteTag should not be called");
    }

    protected void deleteTag(RandomAccessFile raf, RandomAccessFile tempRaf) throws CannotWriteException, IOException
    {
        throw new RuntimeException("MP3FileReader.getEncodingInfo should be called");
    }
}


