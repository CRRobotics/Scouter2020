def commit_data(cursor, data):

    import sqlite3
    
    cursor.execute("CREATE TABLE IF NOT EXISTS data_table (crossing BOOLEAN, lowhigh_auto INTEGER, \
    reach_capacity BOOLEAN, lowhigh INTEGER, spin BOOLEAN, climb BOOLEAN, capacity BOOLEAN)")
    cursor.execute("INSERT INTO data_table
    
    local_data = "INSERT INTO data_table (crossing, lowhigh_auto, reach_capacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?)"
    local_backup = "INSERT INTO data_table (crossing, lowhigh_auto, reach_capacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?)",
                   
    conn = sqlite3.connect(database.db)
    cursor.execute(local_data, data)
    conn.commit()
    for row in cursor:
        print(row)
    cursor.close()
