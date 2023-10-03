with youngest_employee as (
        select 'youngest' as type, name AS name, birthday as birthday
        from worker
        order by birthday asc limit 1),
    oldest_employee as (
        select 'oldest' as type, name as name, birthday as birthday
        from worker
        order by birthday desc limit 1)
select * from youngest_employee
union all
select * from oldest_employee;
