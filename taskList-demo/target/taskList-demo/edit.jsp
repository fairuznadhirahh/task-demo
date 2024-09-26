<%@ taglib uri = "/struts-tags" prefix="s" %>
<html>
<head>
    <title>Edit task</title>
</head>
<body>
    <h2>Edit task</title>
    <s:form action="edit" method="post">
        <s:textfield name="title" label="Title"/>
        <s:textfield name="description" label="Description"/>
        <s:textfield name="status" label="Status"/>
        <s:submit value="Update"/>
    </s:form>

</body>
</html>