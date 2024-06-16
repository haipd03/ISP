<%-- 
    Document   : menu2
    Created on : May 17, 2024, 9:34:36 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <aside id="sidebar" class="bg-side-nav w-1/2 md:w-1/6 lg:w-1/6 border-r border-side-nav hidden md:block lg:block">
            <ul class="list-reset flex flex-col">
                <li class=" w-full h-full py-3 px-2 border-b border-light-border " >
                    <a href="listphong"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fas fa-tachometer-alt float-left mx-2"></i>
                        Phòng
                        <span><i class="fas fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border ">
                    <a href="khu"
                       class="font-sans font-hairline hover:font-normal  text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Khu
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <c:if test="${sessionScope.acc.role == 0}">
                    <li class="w-full h-full py-3 px-2 border-b border-light-border">
                        <a href="listaccount"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fab fa-wpforms float-left mx-2"></i>
                            Tài Khoản
                            <span><i class="fa fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                </c:if>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="listchitietkhachthue"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Khách Thuê
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="listhopdong"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Hợp Đồng
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <c:if test="${sessionScope.acc.role == 0}">
                    <li class="w-full h-full py-3 px-2 border-b border-light-border">
                        <a href="listhoadon"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fab fa-wpforms float-left mx-2"></i>
                            Hóa Đơn
                            <span><i class="fa fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc.role == 0}">
                    <li class="w-full h-full py-3 px-2 border-b border-light-border">
                        <a href="listdichvu"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fab fa-wpforms float-left mx-2"></i>
                            Dịch vụ
                            <span><i class="fa fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                </c:if>

                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="ListAllThietBi?action=get"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Thiết Bị
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="buttons.html"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fas fa-grip-horizontal float-left mx-2"></i>
                        Buttons
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="tables.html"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fas fa-table float-left mx-2"></i>
                        Tables
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="ui.html"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-uikit float-left mx-2"></i>
                        Ui components
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-300-border">
                    <a href="modals.html" class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fas fa-square-full float-left mx-2"></i>
                        Modals
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2">
                    <a href="#"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="far fa-file float-left mx-2"></i>
                        Pages
                        <span><i class="fa fa-angle-down float-right"></i></span>
                    </a>
                    <ul class="list-reset -mx-2 bg-white-medium-dark">
                        <li class="border-t mt-2 border-light-border w-full h-full px-2 py-3">
                            <a href="login.html"
                               class="mx-4 font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                Login Page
                                <span><i class="fa fa-angle-right float-right"></i></span>
                            </a>
                        </li>
                        <li class="border-t border-light-border w-full h-full px-2 py-3">
                            <a href="register.html"
                               class="mx-4 font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                Register Page
                                <span><i class="fa fa-angle-right float-right"></i></span>
                            </a>
                        </li>
                        <li class="border-t border-light-border w-full h-full px-2 py-3">
                            <a href="404.html"
                               class="mx-4 font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                                404 Page
                                <span><i class="fa fa-angle-right float-right"></i></span>
                            </a>
                        </li>
                    </ul>
                </li>

            </ul>
        </aside>
    </body>
</html>
