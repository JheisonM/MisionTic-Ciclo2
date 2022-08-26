select ID_MaterialConstruccion as ID, Nombre_Material as NOMBRE, Precio_Unidad as PRECIO 
from MaterialConstruccion
where Importado = 'Si'
order by Nombre_Material asc;

select py.ID_Proyecto as ID, 
        py.Constructora, py.Ciudad, py.Clasificacion, tp.Estrato,
        (ld.Nombre || ' ' || ld.Primer_Apellido || ' ' || ld.Segundo_Apellido) as LIDER
from Proyecto as py
left join Tipo as tp on py.ID_Tipo = tp.ID_Tipo
left join Lider as ld on py.ID_Lider = ld.ID_Lider
where py.Banco_Vinculado = 'Conavi'
order by py.Fecha_Inicio desc, py.Ciudad asc, py.Constructora asc;

select Ciudad, Clasificacion, count(ID_Proyecto) as TOTAL, 
min(Fecha_Inicio) as VIEJO, max(Fecha_Inicio) as RECIENTE
from Proyecto
where Clasificacion != 'Casa Campestre' and Clasificacion != 'Condominio'
group by Ciudad, Clasificacion;

select p.ID_Proyecto, sum(c.Cantidad * mc.Precio_Unidad) as VALOR
from Proyecto p
left join  Compra c on p.ID_Proyecto = c.ID_Proyecto
left join MaterialConstruccion mc on mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion  
where c.Pagado == 'No'
GROUP by p.ID_Proyecto
HAVING VALOR > 50000
ORDER by VALOR desc;

SELECT (ld.Nombre || ' ' || ld.Primer_Apellido || ' ' || ld.Segundo_Apellido) as LIDER, sum(c.Cantidad * mc.Precio_Unidad) as VALOR 
FROM Lider ld 
LEFT JOIN Proyecto p ON p.ID_Lider = ld.ID_Lider 
LEFT JOIN  Compra c ON p.ID_Proyecto = c.ID_Proyecto 
LEFT JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion 
GROUP BY LIDER 
ORDER BY VALOR DESC 
LIMIT 10;