# mvc
Code sample for spring boot 1.3 integration with hibernate 5.1

localhost:8080

select 
users0_.id as id1_1_, users0_.password as password2_1_, users0_.username as username3_1_ 
from Users users0_ 
inner join Invoices invoices1_ 
on (users0_.id=invoices1_.userId) 
where invoices1_.id=?
