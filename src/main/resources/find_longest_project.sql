with longest_project as (select p.id as project_id, p.start_date, p.finish_date,
extract (month from age (p.finish_date, p.start_date)) as months from project p)
select pd.project_id, pd.months from longest_project pd
where pd.months = (select max (months) from longest_project
);
