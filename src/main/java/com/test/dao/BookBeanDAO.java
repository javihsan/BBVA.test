package com.test.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;
import com.test.data.BookBean;

/**
 * @author BBVA Test
 * Book DAO
 */
public class BookBeanDAO {

    private static final Logger LOGGER = Logger.getLogger(BookBeanDAO.class.getName());

    /**
     * No es posible hacer un ignoreCase en las querys al Datastore.
     * No es posible hacer un % like (endsWith). 
     * Se puede simular un like % (startsWith): q.filter("author >=", searchText).filter("author <",searchText + "\uFFFD").
     * Pero implicaría hacerlo solo en un campo (necesitamos name y author), de lo contrario se da una Exception "Only one inequality filter per query is supported".
     * Asi que  haremos los filtros ignoreCase y % like % por java, recorriendo la lista y quitando los que no cumplan 
     * @param searchText
     * @return list of book beans filter by searchText order by author
     */
    public List<BookBean> list(String searchText) {
        LOGGER.info("Retrieving list of beans filter by '" + searchText + "' order by author");
        
        List<BookBean> list = ObjectifyService.ofy().load().type(BookBean.class).order("author").list();
      
        if (searchText!=null){
        	List<BookBean> listResult = new ArrayList<BookBean>();
        	searchText = searchText.toLowerCase();
        	for (BookBean bookBean : list) {
        		if(bookBean.getName().toLowerCase().contains(searchText)
        				|| bookBean.getAuthor().toLowerCase().contains(searchText)){
        			listResult.add(bookBean);
        		}
        	}
        	return listResult;
        } 
		        
        return list;
    }
    
    /**
     * @param id
     * @return book bean with given id
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
