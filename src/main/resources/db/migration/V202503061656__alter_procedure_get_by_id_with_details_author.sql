BEGIN;
    DROP PROCEDURE IF EXISTS prc_get_by_id_with_details_author;
    CREATE PROCEDURE prc_get_by_id_with_details_author (IN a_id BIGINT)
    BEGIN
        SELECT
            a.id AS aut_id,
            a.name AS aut_name,
            a.occupation AS aut_occupation,
            GROUP_CONCAT(DISTINCT c.id) AS cs_id,
            GROUP_CONCAT(c.`type`) AS cs_type,
            GROUP_CONCAT(DISTINCT c.label) AS cs_label,
            GROUP_CONCAT(DISTINCT p.id) AS ps_id,
            GROUP_CONCAT(DISTINCT p.name) AS ps_name,
            GROUP_CONCAT(p.category) AS ps_category,
            GROUP_CONCAT(DISTINCT p.description) AS ps_description,
            GROUP_CONCAT(DISTINCT g.id) as gs_id,
            GROUP_CONCAT(DISTINCT g.name) as gs_name,
            GROUP_CONCAT(g.category) as gs_category,
            GROUP_CONCAT(DISTINCT g.description) as gs_description,
            GROUP_CONCAT(DISTINCT t.id) AS ts_id,
            GROUP_CONCAT(DISTINCT t.name) AS ts_name,
            GROUP_CONCAT(DISTINCT t.resume) AS ts_resume,
            GROUP_CONCAT(DISTINCT t.description) AS ts_description
        FROM
            authors a
        LEFT JOIN
            contacts c ON c.author_id = a.id
        LEFT JOIN
            projects_access pa ON a.id = pa.author_id
        LEFT JOIN
            projects p ON pa.project_id = p.id
        LEFT JOIN
            authors_group ag ON a.id = ag.author_id
        LEFT JOIN
    		`groups` g ON g.id = ag.group_id
        LEFT JOIN
            authors_task at ON a.id = at.author_id
        LEFT JOIN
            tasks t ON at.task_id = t.id
        WHERE
            a.id = a_id
        GROUP BY
            a.id, a.name, a.occupation;
    END;
COMMIT;