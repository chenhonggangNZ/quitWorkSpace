package com.xinyou.bookstore.book.service;


import com.xinyou.bookstore.book.dao.BookDao;
import com.xinyou.bookstore.book.domain.Book;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    public static Book findBookByBid(String bid) throws SQLException {
         return BookDao.findBookByBid(bid);
    }
    public static List<Book> findBookByCid(String cid) throws SQLException {
        return BookDao.findBookByCid(cid);
    }

    public static List<Book> findAllBook() throws SQLException {
        return BookDao.findAllBook();
    }

    public static Map<String, Book> findBookByBid(List<String> bid) throws SQLException {
        Map<String,Book> bookMap = new HashMap<>();
        for (String s : bid) {
            Book bookByBid = findBookByBid(s);
            bookMap.put(s,bookByBid);
        }
        return bookMap;
    }

    public static Map<String, String> ParsingForm(String realPath, FileItemIterator itemIterator) throws FileUploadException, IOException {
        Map<String,String> form = new HashMap<>();
        String name = " ";
        long l = 0;
        while (itemIterator.hasNext()){
            FileItemStream next = itemIterator.next();
            String fieldName = next.getFieldName();
            if (fieldName.equals("image")){
                 name = next.getName();
            }
            if (name.contains("jpg")){
                 l = System.currentTimeMillis();
                FileOutputStream fos = new FileOutputStream(realPath+l+".jpg");
                InputStream inputStream = next.openStream();
                byte[] bytes = new byte[1024*1024];
                int length = 0;
                if ((length = inputStream.read(bytes)) != -1){
                    fos.write(bytes,0,length);
                }
                fos.flush();
                fos.close();
                form.put("image",l+".jpg");
                name = "1";
            }
            if (name.contains("png")){
                 l = System.currentTimeMillis();
                FileOutputStream fos = new FileOutputStream(realPath+l+".png");
                InputStream inputStream = next.openStream();
                byte[] bytes = new byte[1024*1024];
                int length = 0;
                if ((length = inputStream.read(bytes)) != -1){
                    fos.write(bytes,0,length);
                }
                fos.flush();
                fos.close();
                form.put("image",l+".png");
                name = "1";
            }
            form.put(fieldName,next.getContentType());
        }
        return form;
    }

    public static Book generateBook(Map<String, String> form) throws SQLException {
        Book book = new Book();
        String image = "book_img/"+form.get("image");
        book.setImage(image);
        book.setAuthor(form.get("author"));
        book.setBname(form.get("bname"));
        book.setCid(form.get("cid"));
        book.setPrice(form.get("price"));
        String bid = BookDao.findMaxBid();
        int i = 1;
        try{
            i = Integer.parseInt(bid);
        i++;
        } catch (java.lang.NumberFormatException e){}
        book.setBid(String.valueOf(i));
        return book;
    }

    public static void saveBook(Book book) throws SQLException {
        Book bookByBid = BookDao.findBookByBid(book.getBid());
        if (bookByBid != null && bookByBid.getBid().equals(book.getBid())){
            BookDao.editDelete(book.getBid());
            return;
        }
        BookDao.saveBook(book);
    }

    public static void deleteBook(String bid) throws SQLException {
            BookDao.deleteBook(bid);
    }

    public static void editBook(Book book) throws SQLException {
        BookDao.editBook(book);
    }
}
