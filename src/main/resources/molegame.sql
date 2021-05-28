use molegame;
delimiter $
create procedure sp_ranking (var_level varchar(6))
begin
select distinct r.score, u.username
from ranking r inner join user u on u.id = r.user_id
where r.level = var_level
order by score desc , r.id
limit 5;
end $
delimiter ; 