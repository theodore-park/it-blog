ALTER TABLE `users`
    ADD `created_at` datetime NOT NULL,
    ADD `updated_at` datetime NOT NULL;

ALTER TABLE boards
    ADD `created_at` datetime NOT NULL,
    ADD `updated_at` datetime NOT NULL;