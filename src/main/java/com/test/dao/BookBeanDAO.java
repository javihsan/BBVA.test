package com.test.dao;

import com.googlecode.objectify.ObjectifyService;
import com.test.data.BookBean;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author BBVA Test
 * Book DAO
 */
public class BookBeanDAO {

    private static final Logger LOGGER = Logger.getLogger(BookBeanDAO.class.getName());

    /**
     * @return list of test beans
     */
    public List<BookBean> list() {
        LOGGER.info("Retrieving list of beans");
        return ObjectifyService.ofy().load().type(BookBean.class).list();
    }

    /**
     * @param id
     * @return test bean with given id
     */
    public BookBean get(Long id) {
        LOGGER.info("Retrieving bean " + id);
        return ObjectifyService.ofy().load().type(BookBean.class).id(id).now();
    }

    /**
     * Saves given bean
     * @param bean
     */
    public void save(BookBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("null test object");
        }
        LOGGER.info("Saving bean " + bean.getId());
        ObjectifyService.ofy().save().entity(bean).now();
    }

    /**
     * Deletes given bean
     * @param bean
     */
    public void delete(BookBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("null test object");
        }
        LOGGER.info("Deleting bean " + bean.getId());
        ObjectifyService.ofy().delete().entity(bean);
    }
}
