package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

/*calsse auxilar para instanciar os Daos
 * 
 */

public class DaoFactory {

	public static  SellerDao creatSellerDao(){
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	
}
