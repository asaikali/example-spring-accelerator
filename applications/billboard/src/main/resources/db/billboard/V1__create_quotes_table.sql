CREATE
  TABLE
    quotes(
      id BIGSERIAL PRIMARY KEY,
      version INTEGER NOT NULL,
      insert_ts TIMESTAMP WITH TIME ZONE NOT NULL,
      update_ts TIMESTAMP WITH TIME ZONE NOT NULL,
      quote VARCHAR(1024),
      author VARCHAR(256)
    );

-- INSERT
 --   INTO
 --     quotes(
 --       quote,
 --       author,
 --       insert_ts,
 --       update_ts,
 --       version
 --     )
 --   VALUES(
 --     'Never, never, never give up',
 --     'Winston Churchill',
 --     now(),
 --     now(),
 --     0
 --   );
 INSERT
  INTO
    quotes(
      quote,
      author,
      insert_ts,
      update_ts,
      version
    )
  VALUES(
    'While there''s life, there''s hope',
    'Marcus Tullius Cicero',
    now(),
    now(),
    0
  );

INSERT
  INTO
    quotes(
      quote,
      author,
      insert_ts,
      update_ts,
      version
    )
  VALUES(
    'Failure is success in progress',
    'Anonymous',
    now(),
    now(),
    0
  );

INSERT
  INTO
    quotes(
      quote,
      author,
      insert_ts,
      update_ts,
      version
    )
  VALUES(
    'Success demands singleness of purpose',
    'Vincent Lombardi',
    now(),
    now(),
    0
  );

INSERT
  INTO
    quotes(
      quote,
      author,
      insert_ts,
      update_ts,
      version
    )
  VALUES(
    'The shortest answer is doing',
    'Lord Herbert',
    now(),
    now(),
    0
  );
