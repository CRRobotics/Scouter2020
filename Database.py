def commit_data(data):
    
    import sqlite3
    
    conn = sqlite3.connect(database.db)
    cur = conn.cursor()
    
    cur.execute("CREATE TABLE IF NOT EXISTS data_table (crossing BOOLEAN, lowhigh_auto INTEGER, \
    reach_capacity BOOLEAN, lowhigh INTEGER, spin BOOLEAN, climb BOOLEAN, capacity BOOLEAN)")
    cur.execute("INSERT INTO data_table
    
    local_data = "INSERT INTO data_table (crossing, lowhigh_auto, reach_capacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?)"
    local_backup = "INSERT INTO data_table (crossing, lowhigh_auto, reach_capacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?)"
                   
    cur.execute(local_data, data)
    conn.commit()
    for row in cursor:
        print(row)
    
    cursor.close()

    
    
