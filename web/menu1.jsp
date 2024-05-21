<%-- 
    Document   : menu1
    Created on : May 17, 2024, 9:34:20 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header class="bg-nav">
            <div class="flex justify-between">
                <div class="p-1 mx-3 inline-flex items-center">
                    <i class="fas fa-bars pr-2 text-white" onclick="sidebarToggle()"></i>
                    <a href="listphong" class="text-white p-2">Home</a>
                </div>

                <div class="p-1 flex flex-row items-center">


                    <a  onclick="profileToggle()" class="text-white p-2 no-underline hidden md:block lg:block">Hello ${sessionScope.acc.taiKhoan}</a>
                    <div id="ProfileDropDown" class="rounded hidden shadow-md bg-white top-0 right-0 absolute pin-t mt-12 mr-1 pin-r">
                        <ul class="list-reset">
                            <li><a href="loadmyaccount?id=${sessionScope.acc.accountID}" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">My account</a></li>
                            <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Notifications</a></li>
                            <li><hr class="border-t mx-2 border-grey-ligght"></li>
                            <li><a href="logout" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
