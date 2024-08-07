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
        <style>
            .white-image {
                filter: invert(100%) sepia(0%) saturate(0%) hue-rotate(180deg) brightness(100%) contrast(100%);
            }
            .badge {
                background-color: yellowgreen;
                color: white;
                border-radius: 50%;
                padding: 0.5em;
                font-size: 0.65em;
                margin-left: 15px;
            }
        </style>
        <script>
            function updateUnreadCount() {
                fetch('unreadCount')
                    .then(response => response.json())
                    .then(data => {
                        document.getElementById('unreadCountBadge').textContent = data.unreadCount;
                    })
                    .catch(error => console.error('Error fetching unread count:', error));
            }

            // Update every second
            setInterval(updateUnreadCount, 1000);
            
            // Initial update
            document.addEventListener('DOMContentLoaded', (event) => {
                updateUnreadCount();
            });
        </script>
    </head>
    <body>
        <header class="bg-nav">
            <div class="flex justify-between">
                <div class="p-1 mx-3 inline-flex items-center">
                    <i class="fas fa-bars pr-2 text-white" onclick="sidebarToggle()"></i>
                    <a href="listphong" class="text-white p-2">Trang chủ</a>
                </div>

                <div class="p-1 flex flex-row items-center">
                    <a href="ListRequest" class="no-underline">
                        <span class="badge" id="unreadCountBadge">${sessionScope.un}</span>
                        <img src="dist/images/mailbox.png" alt="Mailbox" class="mr-2 white-image" width="30" height="30">
                    </a>
                    <a onclick="profileToggle()" class="text-white p-2 no-underline hidden md:block lg:block">
                        <i class="fas fa-user"></i> <!-- Icon người dùng -->
                        <span class="ml-2">${sessionScope.acc.taiKhoan}</span> <!-- Tên tài khoản -->
                    </a>
                    <div id="ProfileDropDown" class="rounded hidden shadow-md bg-white top-0 right-0 absolute pin-t mt-12 mr-1 pin-r">
                        <ul class="list-reset">
                            <li><a href="loadmyaccount?id=${sessionScope.acc.accountID}" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Thông tin tài khoản</a></li>
                            <li><hr class="border-t mx-2 border-grey-ligght"></li>
                            <li><a href="logout" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Đăng xuất</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
