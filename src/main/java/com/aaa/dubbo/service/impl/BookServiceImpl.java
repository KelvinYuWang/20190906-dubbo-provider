package com.aaa.dubbo.service.impl;

import com.aaa.dubbo.mapper.BookMapper;
import com.aaa.dubbo.model.Book;
import com.aaa.dubbo.service.IBookService;
import com.aaa.dubbo.statuscode.StatusEnum;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BookServiceImpl
 * @Author 王宇
 * @Date 2019/9/6 16:24
 * @Version 1.0
 *      jdk1.4版本不需要添加@Override注解，如果添加，就会报错
 */
@Service(timeout = 5000)
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询所有图书
     * @return
     */
    @Override
    public Map<String, Object> selectAllBook() {
        System.out.println("8081");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Book> books = bookMapper.selectAllBook();
        if (books.size() > 0) {
            resultMap.put("code", StatusEnum.SUCCESS.getCode());
            resultMap.put("result",books);
        } else {
            resultMap.put("code", StatusEnum.FAILED.getCode());
        }
        return resultMap;
    }

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> deleteBook(Integer id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int result = bookMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            //说明删除成功
            resultMap.put("code", StatusEnum.SUCCESS.getCode());
        } else {
            resultMap.put("code", StatusEnum.FAILED.getCode());
        }
        return resultMap;
    }

    /**
     * 根据传参是否包含id判断插入还是更新
     * @param book
     * @return
     */
    @Override
    public Map<String, Object> insertOrUpdateBook(Book book) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int id = 0;
        if (null != book.getId()) {
            id = book.getId();
        }
        if (0 == id) {
            int result = bookMapper.insertSelective(book);
            if (result > 0) {
                //说明添加成功
                resultMap.put("code", StatusEnum.SUCCESS.getCode());
            } else {
                resultMap.put("code", StatusEnum.FAILED.getCode());
            }
        } else if (id > 0 ){
            int result = bookMapper.updateByPrimaryKeySelective(book);
            if (result > 0) {
                //说明修改成功
                resultMap.put("code", StatusEnum.SUCCESS.getCode());
            } else {
                resultMap.put("code", StatusEnum.FAILED.getCode());
            }
        } else {
            resultMap.put("code", StatusEnum.ERROR.getCode());
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> selectByPrimaryKey(Integer id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Book book = bookMapper.selectByPrimaryKey(id);
        if (null != book) {
            resultMap.put("code", StatusEnum.SUCCESS.getCode());
            resultMap.put("result", book);
        } else {
            resultMap.put("code", StatusEnum.FAILED.getCode());
        }
        return resultMap;
    }
}
