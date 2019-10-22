<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.bulletin.list.label.patrocinador" path="patrocinador" width="10%"/>
	<acme:list-column code="anonymous.bulletin.list.label.equipo" path="equipo" width="20%"/>
	<acme:list-column code="anonymous.bulletin.list.label.nacimiento" path="nacimiento" width="60%"/>
	<acme:list-column code="anonymous.bulletin.list.label.dorsal" path="dorsal" width="10%"/>
</acme:list>
