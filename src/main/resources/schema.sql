CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY ,
    title varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
);

INSERT INTO Content (title, description, status, content_type, date_created, date_updated, url)
VALUES
    ('First Post', 'This is the first post on the blog.', 'IDEA', 'ARTICLE', '2023-02-13 10:25:02', NULL, 'http://example.com/first-post'),
    ('Second Post', 'This is the second post on the blog.', 'PUBLISHED', 'VIDEO', '2023-03-10 14:15:00', '2023-03-15 18:30:00', 'http://example.com/second-post');
