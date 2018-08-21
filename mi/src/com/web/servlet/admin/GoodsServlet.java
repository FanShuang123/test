package com.web.servlet.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.web.dao.GoodsDao;
import com.web.factory.DaoFactory;
import com.web.idao.IGoodsDao;
import com.web.vo.Category;
import com.web.vo.Goods;

public class GoodsServlet extends HttpServlet {
	
	String path=null;
	
	 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//IGoodsDao goodsDao=new GoodsDao();
		String 	action=request.getParameter("action");
		if(action.equals("addGoods")){	
			
			addGoods(request,response);
				
		}else if(action.equals("showGoods")){
			showGoods(request,response);
		}else if("queryById".equals(action)){
			queryById(request,response);
		}else if("modGoods".equals(action)){
			
			modGoods(request,response);
			
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);	
	}

	private void modGoods(HttpServletRequest request,HttpServletResponse response) {
		 // int id=Integer.parseInt(request.getParameter("id"));
		   IGoodsDao goodsDao=DaoFactory.getGoodsDao();
		  // Goods goods=(Goods)request.getParameter("id");
		   //接受值必须new 对象?  不能传递对象?
		   System.out.println(request.getParameter("goods_price"));
		 Goods  goods =new Goods();
		 String goods_name=request.getParameter("goods_name");
		 int goods_id=Integer.parseInt(request.getParameter("goods_id"));
         double goods_price=Double.parseDouble(request.getParameter("goods_price"));
         String  goods_img=request.getParameter("goods_img");
         Category category = new Category();
         int cat_id=Integer.parseInt(request.getParameter("cat_id")); 
         category.setCat_id(cat_id);
      
         goods.setGoods_id(goods_id);
         goods.setGoods_img(goods_img);
         goods.setCategory(category);
         goods.setGoods_name(goods_name);
         goods.setGoods_price(goods_price);
		 	 

		/* goods.setCategory(request.getParameter(""));
		 * 
		 * */
		 
		 
		   int num=goodsDao.modGoods(goods);
		
		if(num>0){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		path="goodsServlet?action=showGoods";
		
	}


	private void queryById(HttpServletRequest request,HttpServletResponse response) {
		IGoodsDao goodsDao=DaoFactory.getGoodsDao();
		int id=Integer.parseInt(request.getParameter("id"));
		Goods goods=goodsDao.queryById(id);
		request.setAttribute("goods",goods);
		path="admin/main/modGoods.jsp";
		
		
		
	}


	private void showGoods(HttpServletRequest request,HttpServletResponse response) {
	    //利用DaoFactory  Dao库来创建IGoodsDao 对象 
	     IGoodsDao goodsDao=DaoFactory.getGoodsDao();
	     List<Goods> goodsList=goodsDao.showGoods();
	  request.setAttribute("goodsList", goodsList);
	  
	    path="admin/main/showGoods.jsp";
	  
		
	}


	//添加商品
		private void addGoods(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
			Map<String,String> map = new HashMap<String,String>();
			
			//声明文件操作工厂对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//声明文件操作对象的解析
			ServletFileUpload upload = new ServletFileUpload(factory);
			if(upload.isMultipartContent(request)){
				try {
					List<FileItem> list = upload.parseRequest(request);
					for(FileItem item : list){
						if(item.isFormField()){
							//普通框的内容
							String name = item.getFieldName();
							String value = null;
							try {
								value = item.getString("utf-8");
							} catch (UnsupportedEncodingException e) {
						
								e.printStackTrace();
							}
							
							map.put(name, value);
							
							//System.out.println(map.values()+"map!!!!!!!!!!");
							  
						}else{
							//文件框的内容
							String name = item.getFieldName();
							//错误
							
							String value = item.getName();
							 //截取 文件名
							String value1=value.substring(value.lastIndexOf("\\")+1);
							
							//System.out.println(name+"----------"+value);
							//System.out.println(name+"----------"+value1);
							
							//上传文件
							try {
								InputStream input = item.getInputStream();
								//
								//获得服务器地址
								String path = this.getServletContext().getRealPath("/image");
								//System.out.println(path+"~~~~~~~~~~");
								File file = new File(path+File.separator+value1);
								System.out.println(file.getAbsolutePath()+"~~~~~~~~~~");
								FileOutputStream output = new FileOutputStream(file);
								byte[] buff = new byte[1024*10];
								int length = 0;
								while((length = input.read(buff))!=-1){
									output.write(buff, 0, length);
								}
								input.close();
								output.close();
								/*System.out.println(path);*/
								
								map.put(name,file.getName());
								
								
								
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
				}catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				IGoodsDao goodsDao =DaoFactory.getGoodsDao();
				int num = goodsDao.addGoods(map);
				//页面跳转
				// HttpSession  session=request.getSession();
				if(num>0){
					
					/*session.setAttribute("error", "添加商品成功！<a href='servlet/GoodsServlet?action=showGoods'>点击</a>返回");*/
					request.setAttribute("msg", "添加商品成功！<a href='servlet/GoodsServlet?action=showGoods'>点击</a>返回");
					path="admin/main/message.jsp";
//					System.out.println("request::::"+request+",,,,,,path:"+path+",------reponse:"+response);	
		
//					request.getRequestDispatcher(path).forward(request,response);
	
					
				}else{
					request.setAttribute("msg", "添加商品失败！<a href='servlet/GoodsServlet?action=showGoods'>点击</a>返回");
					 path="admin/main/message.jsp";
				
				
			
				
			}
			}
		}}


