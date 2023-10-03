with project_costs as (
    select p.id as project_id, p.start_date, p.finish_date,
        (extract(month from age(p.finish_date, p.start_date))+1) as duration_in_months,
        sum(w.salary) as total_p_cost
    from project p
    join project_worker pw on p.id = pw.project_id
    join worker w on pw.worker_id = w.id
    group by p.id, p.start_date, p.finish_date)
select p.id as project_id, pc.total_p_cost * pc.duration_in_months as project_cost
from project p
join project_costs pc on p.id = pc.project_id
order by project_cost desc;
