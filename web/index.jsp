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
        <title>Ordenar comida</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.css" rel="stylesheet" />
        <link href="./css/styles.css" rel="stylesheet" />
    </head>

    <body>
        <div class="container mt-5">
            <h3 class="text-center">Pedir comida rápida</h3>
            <div id="chat" class="chat">
                <div class="mensajeria">
                    <div class="mensajes">
                        <div class="historial">
                            <!--<div class="bot">
                                <div class="img_bot"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                                <div class="recibido">
                                    <div class="men_recibido">
                                        <p>asd <% out.print(error); %></p>
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
                                        out.print("<div class='img_bot'> <img src='https://ptetutorials.com/images/user-profile.png' alt='sunil'> </div>");
                                        out.print("<div class='recibido'>");
                                        out.print("<div class='men_recibido'>");
                                        out.print("<p>" + chat.mensajes.get(i).mensaje + error + "</p>");
                                        out.print("<span class='fecha'>" + chat.mensajes.get(i).fecha + "</span>");
                                        out.print("</div></div></div>");
                                    } else if (chat.mensajes.get(i).autor == 1) {
                                        out.print("<div class='enviado'>");
                                        out.print("<div class='men_enviado'>");
                                        out.print("<p>" + chat.mensajes.get(i).mensaje + "</p>");
                                        out.print("<span class='fecha'>" + chat.mensajes.get(i).fecha + "</span>");
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