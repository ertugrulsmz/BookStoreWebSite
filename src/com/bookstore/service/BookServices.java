package com.bookstore.service;



import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookServices extends GeneralServices {
	
	private BookDao bookDao;
	private CategoryDao categoryDao;
	
	public BookServices(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		bookDao=new BookDao();
		categoryDao=new CategoryDao();
	}
	
	public void ListBooks() throws ServletException, IOException {
		ListBooks(null);
	}
	
	public void ListBooks(String message) throws ServletException, IOException
	{
		List<Book> booklist=bookDao.listall();
		request.setAttribute("a","assad");
		request.setAttribute("booklist",booklist);
		request.setAttribute("message",message);
		request.getRequestDispatcher("/admin/booklist.jsp").forward(request,response);
		
	}
	
	
	public void OpenBookForm() throws ServletException, IOException
	{
		List<Category> categoryList=categoryDao.listall();
		request.setAttribute("categoryList",categoryList);
		request.getRequestDispatcher("book_form.jsp").forward(request,response);
		
	}
	
	public void readBookFromJsp(Book book) throws IOException, ServletException {
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String isbn=request.getParameter("isbn");
		
		Date date=null;
		String publishdate=request.getParameter("publishdate");
		SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
		try {
			date=dateformat.parse(publishdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		Part part=request.getPart("bookimage");
		byte[] imageBytes=null;
		
		
		if(part!=null && part.getSize()>0) {
			System.out.println("yyyyyyyyyyyyyyyyyy");
			long size=part.getSize();
			imageBytes=new byte[(int) size];
			
			InputStream inputStream=part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			book.setImage(imageBytes);
		}
		
		
		String category=request.getParameter("category");
		Category categoryForBook=categoryDao.get(Integer.parseInt(category));
		
		book.setAuthor(author);
		
		book.setCategory(categoryForBook);
		book.setIsbn(isbn);
		book.setPrice(Float.parseFloat(price));
		book.setTitle(title);
		System.out.println("**********************************************");
		System.out.println("Book title22222 : ----- : "+book.getTitle());
		book.setPublish_date(date);
		book.setDescription(description);
		
	}
	

	public void createBook() throws IOException, ServletException {
		
		Book book=new Book();
		readBookFromJsp(book);
		
		//bookdao create
		Book  sametitlebook=bookDao.findByTitle(book.getTitle());
		if(sametitlebook==null) {
			bookDao.create(book);
			ListBooks();
		}else {
			ListBooks("Duplicate Title , couldn't created");
		}
		
	}

	public void editBook() throws ServletException, IOException {

		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		Book book=bookDao.get(id);
		request.setAttribute("book",book);
		
		Category categoryofbook=categoryDao.get(book.getCategory().getCategory_id());
		request.setAttribute("selected_category",categoryofbook);
		
		List<Category> categories=categoryDao.listall();
		request.setAttribute("categoryList",categories);
		
		
		request.getRequestDispatcher("book_form.jsp").forward(request,response);
		
	}

	public void updateBook() throws IOException, ServletException {
		
		String book_idString=request.getParameter("id");
		Book book=bookDao.get(Integer.parseInt(book_idString));
		readBookFromJsp(book);
		
		Book sametitleBook=bookDao.findByTitle(book.getTitle());
		
		if(sametitleBook!=null && !(sametitleBook.getBook_id().equals(book.getBook_id()))) {
			String messageString="There is a book with same title";
			this.ListBooks(messageString);
			return;
		}
		
		
		bookDao.update(book);
		this.ListBooks("BookListUpdated");
		
		
	}

	public void delete() throws ServletException, IOException {
		String book_idString=request.getParameter("bookid");
		int bookid=Integer.parseInt(book_idString);
		bookDao.delete(bookid);
		this.ListBooks();
		
	}
	
	public void listbycategory() throws ServletException, IOException
	{
		//header titles
		List<Category> categories=categoryDao.listall();
		request.setAttribute("categorylist",categories);
		
		String idString=request.getParameter("id");
		int id=Integer.parseInt(idString);
		List<Book> listbook=bookDao.ListByCategory(id);
		
		request.setAttribute("booklist",listbook);
		request.getRequestDispatcher("/frontend/books_by_category.jsp").forward(request,response);
		
	}
	
	public void prepareHomePage() throws ServletException, IOException {
		List<Book> newBookList=bookDao.listNewBooks();
		request.setAttribute("newbooklist",newBookList);
		
		List<Book> mostselledbooks=bookDao.mostSelledBooks();
		request.setAttribute("mostselledbooks",mostselledbooks);
		
		List<Book> mostFavouredBooks=bookDao.mostFavouredBooksExtract();
		request.setAttribute("mostfavouredbooks",mostFavouredBooks);
		
		
		String pathString="frontend/index.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(pathString);
		requestDispatcher.forward(request,response);
	}

	public void viewDetail() throws ServletException, IOException {
		String bookidString=request.getParameter("id");
		int id=Integer.parseInt(bookidString);
		Book book=bookDao.get(id);
		
		
		request.setAttribute("book",book);
		request.getRequestDispatcher("/frontend/view.jsp").forward(request,response);
		
	}
	
	

	public void search() throws ServletException, IOException {
		String searchString=request.getParameter("search");
		
		
		List<Book> booklist=bookDao.searchBooks(searchString);
		request.setAttribute("booklist",booklist);
		
		
		request.getRequestDispatcher("/frontend/search.jsp").forward(request,response);
		
	}

	
	
	
	
	
	
}
