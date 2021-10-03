CREATE
  TABLE
    test(
      name TEXT PRIMARY KEY
    );

INSERT
  INTO
    test(name)
  VALUES('foo');

CREATE
  TABLE
    persistable(
      id BIGSERIAL PRIMARY KEY,
      version INTEGER NOT NULL,
      insert_ts TIMESTAMP WITH TIME ZONE NOT NULL,
      update_ts TIMESTAMP WITH TIME ZONE NOT NULL,
      name TEXT
    );

CREATE
  TABLE
    unique_persistable(
      id UUID PRIMARY KEY,
      version INTEGER NOT NULL,
      insert_ts TIMESTAMP WITH TIME ZONE NOT NULL,
      update_ts TIMESTAMP WITH TIME ZONE NOT NULL,
      name TEXT
    );
