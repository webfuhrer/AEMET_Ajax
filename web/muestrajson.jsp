<%@page import="paqueteajaxaemet.PintarJSON"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paqueteajaxaemet.Municipio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Municipio> lista=(ArrayList<Municipio>)request.getAttribute("lista");
    String json=PintarJSON.pinta(lista);
    %>
<%=json%>
