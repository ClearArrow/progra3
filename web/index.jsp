<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.Mensaje"%>
<%@page import="clases.Chat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>

<%
    Chat chat = (Chat) request.getSession().getAttribute("chat");
    String error = (String) request.getSession().getAttribute("error");
%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordenar comida rápida</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.css" rel="stylesheet" />
        <link href="./css/styles.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container mt-5">
            <h3 class="text-center">Comunícate con una persona de GuateRapid</h3>
            <div id="chat" class="chat">
                <img src="./img/menuguaterapid.png" style="position: absolute; left: 0px;">
                <div class="mensajeria" style="float: right; position: absolute; right: 0px; max-width: 1000px; margin-right: 15px;">
                    <div class="mensajes">
                        <div class="historial" id="historial">
                            <img src='https://miro.medium.com/max/1600/1*fZsdZisozTZbM6AaPQKI4Q.gif' style="max-width: 20%;"><h3 style="display: inline;">Bienvenido a servicios en línea GuateRapid</h3>
                            <!--<div class="bot">
                                <div class="img_bot"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                                <div class="recibido">
                                    <div class="men_recibido">
                                        <p>asd < out.print(error); %></p>
                                        <span class="fecha"> 11:01 AM    |    June 9</span></div>
                                </div>
                            </div>
                            <div class="enviado">
                                <div class="men_enviado">
                                    <p>asd</p>
                                    <span class="fecha"> 11:01 AM    |    June 9</span> </div>
                            </div>-->
                            <%
                                for (int i = 0; i < chat.mensajes.size(); i++) {
                                    if (chat.mensajes.get(i).autor == 0) {
                                        out.print("<div class='bot'>");
                                        out.print("<div class='img_bot'> <img src='https://cdn.dribbble.com/users/2788963/screenshots/6829123/characterheadgif3.gif' alt='sunil' style='width: 65px; height: 50px; max-width: inherit; margin-top: 20px;'> </div>");
                                        out.print("<div class='recibido'>");
                                        out.print("<span class='fecha'>NEO</span>");
                                        out.print("<div class='men_recibido'>");
                                        out.print("<p>" + chat.mensajes.get(i).mensaje + error + "</p>");
                                        out.print("<span class='fecha'>" + chat.mensajes.get(i).fecha + "</span>");
                                        out.print("</div></div></div>");
                                    } else if (chat.mensajes.get(i).autor == 1) {
                                        out.print("<div class='enviado'>");
                                        out.print("<div> <img src='https://media.tenor.com/images/1a8c04c853ea57851c56a359d0aeedba/tenor.gif' alt='sunil' style='width: 65px; height: 50px; max-width: inherit; float: right; margin-top:15px;'> </div>");
                                        out.print("<div class='men_enviado'>");
                                        out.print("<span class='fecha' style='text-align: right;'>TÚ</span>");
                                        out.print("<p>" + chat.mensajes.get(i).mensaje + "</p>");
                                        out.print("<span class='fecha' style='text-align: right;'>" + chat.mensajes.get(i).fecha + "</span>");
                                        out.print("</div></div>");
                                    }
                                }
                            %>
                        </div>
                        <div class="texto">
                            <div class="escribir">
                                <input type="text" class="caja_texto" placeholder="Escribe algo" id="mensaje" />
                                <button class="boton_enviar" onclick="enviarMensaje()" type="button"><i class="fas fa-paper-plane" aria-hidden="true"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="limpiar">
            <button class="btn btn-danger">Limpiar</button>
        </div>
        <form method="POST" action="./ChatBot" style="display:none;">
            <input type="hidden" name="borrar" value="si">
        </form>
        <script src="./js/jquery-3.4.1.min.js"></script>
        <script src="./js/popper.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/main.js"></script>
    </body>

</html>