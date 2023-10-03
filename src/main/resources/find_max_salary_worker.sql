select w.name, l.levels_name, w.salary
from worker w
join levels l on w.levels_id = l.levels_id
where w.salary = (select max(salary) from worker);