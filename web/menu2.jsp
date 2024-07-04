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
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="listhoadon"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Hóa Đơn
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="listdichvu"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Dịch vụ
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="ListAllThietBi?action=get"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Thiết Bị
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
                <li class="w-full h-full py-3 px-2 border-b border-light-border">
                    <a href="listthietbichung"
                       class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                        <i class="fab fa-wpforms float-left mx-2"></i>
                        Thiết Bị Chung
                        <span><i class="fa fa-angle-right float-right"></i></span>
                    </a>
                </li>
            </ul>
        </li>

    </ul>
</aside>
</body>
</html>
