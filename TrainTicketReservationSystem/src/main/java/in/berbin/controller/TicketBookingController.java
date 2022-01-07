package in.berbin.controller;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.*;
import in.berbin.model.*;
import in.berbin.dao.*;
import in.berbin.util.*;


import javax.servlet.http.HttpServlet;
@WebServlet("/booking")
public class TicketBookingController extends HttpServlet {

public void service(HttpServletRequest req,HttpServletResponse res) {
        System.out.println("0");
        HttpSession session=req.getSession();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        TrainDaoImpl trainDao=new TrainDaoImpl();
        UserDaoImpl userDao=new UserDaoImpl();
        BookingDetailsDaoImpl bookingdetailsDao=new BookingDetailsDaoImpl();
        System.out.println("1");
        Users user=(Users)session.getAttribute("userdata");
        Users user1=userDao.getUserDetailsById(user.getUserId());
        System.out.println("2");
        int trainId=(int) session.getAttribute("presenttrain");
        Trains trainModel=trainDao.findTrainsDetailsUsingID(trainId);

        System.out.println("3");
       
        int ticketCount=Integer.parseInt(req.getParameter("seatcount"));
        int totalPrice=Integer.parseInt(req.getParameter("totalprice"));
        
//      if(user.getUserWallet()>=totalPrice) {
        System.out.println("4");
        int updateAmountInWallet=user1.getUserwallet()-totalPrice;
        Users userModel=new Users(user1.getUserId(),user1.getUserName(),user1.getUserDob(),user1.getUserEmail(),user1.getUserMobileNumber(),
                user1.getUserGender(),user1.getUserPassword(),updateAmountInWallet);
         UserDaoImpl UserDao = new UserDaoImpl();
         userDao.updateWallet(updateAmountInWallet, user.getUserId());
        System.out.println("5");
        int updateSeatCount=trainModel.getTotalseat()-ticketCount;
        Trains trainModel1=new Trains(trainModel.getTrainId(),trainModel.getTrainName(),trainModel.getTrainClass(),trainModel.getTrainNumber(),trainModel.getTrainSource(),
        		trainModel.getTrainDestination(),trainModel.getTrainDepartureTime(),trainModel.getTrainArraivalTime(),
        		updateSeatCount,trainModel.getTicketPrice());
        TrainDaoImpl trainDao2=new TrainDaoImpl();
        trainDao2.updateSeatCount(trainModel1);
        
        
        System.out.println("6");
        
        BookingDetails bookTickets=new BookingDetails(userModel,trainModel.getTrainId(),trainModel.getTrainDepartureTime().toLocalDate(),ticketCount,totalPrice);
        System.out.println("datetime " +trainModel.getTrainDepartureTime());
        System.out.println("7");
        boolean ticketInsertFlag=bookingdetailsDao.bookTicket(userModel, trainModel, bookTickets);
        session.setAttribute("bookticket", bookTickets);
        session.setAttribute("TrainModel", trainModel);  
        session.setAttribute("lastuserModel", userModel);
        System.out.println("7");
        if(ticketInsertFlag) {
            try {
                res.sendRedirect("BookedSucessful.jsp");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        
        
    }
}
