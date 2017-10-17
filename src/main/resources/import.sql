INSERT INTO nodes (id, name, region, street, house) VALUES (1, 'first node', 'first regon', 'first street', '1'), (2, 'second node', 'second regon', 'second street', '2');
INSERT INTO connection_units (id, name, capacity, node_id) VALUES (1, 'first CU', 10, 1), (2, 'second CU', 5, 2), (3, 'another CU', 5, 2);
INSERT INTO points (id, connection_unit_id, position) VALUES (1, 1, 0), (2, 2, 0);
UPDATE points SET linked_point_id = 2 WHERE id = 1;
UPDATE points SET linked_point_id = 1 WHERE id = 2;