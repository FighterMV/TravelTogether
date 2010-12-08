<head>
    <script type="text/javascript">
         /* <![CDATA[ */
        $(document).ready(function() {
                $("#groups").tablesorter();
        });
        /* ]]> */

        </script>
</head>


<body>

<form method="post" action="createGroup.htm">

    <table id="groups" class="tablesorter">
      <thead>
        <tr>
          <th>Name</th>
          <th>Founder</th>
          <th>Creation Date</th>
          <th>Members</th>
          <th>Forum entries</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>London 2010</td>
          <td>Marco Vreydal</td>
          <td>06.12.2010</td>
          <td>60</td>
          <td>243</td>
        </tr>
        <tr>
          <td>Cologne 2010</td>
          <td>Karola Weischenberg</td>
          <td>05.12.2010</td>
          <td>12</td>
          <td>4</td>
        </tr>
        <tr>
          <td>Berlin 2010</td>
          <td>Andre Kuepper</td>
          <td>04.12.2010</td>
          <td>546</td>
          <td>7817</td>
        </tr>
      </tbody>
    </table>

    <table>
    <tr>
        <td><label>Name:</label></td>
        <td><input name="name" id="name" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Create Group"/>
        </td>
    </tr>
</table>

</form>

</body>
