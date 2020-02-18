def commitToDatabase(data)
    import sqlite3
    
    conn = sqlite3.connect(database.db)
    cur = conn.cursor()
    
    cur.execute("CREATE TABLE IF NOT EXISTS data_table (crossing BOOLEAN, lowhigh_auto INTEGER, \
    reach_capacity BOOLEAN, lowhigh INTEGER, spin BOOLEAN, climb BOOLEAN, capacity BOOLEAN)")
    
    local_data = "INSERT INTO data_table (crossing, lowhigh_auto, reach_capacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?)"
    local_backup = "INSERT INTO data_table (crossing, lowhigh_auto, reach_capacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?)"
                   
    cur.execute(local_data, data)
    conn.commit()
    for row in cursor:
        print(row)
    
    cursor.close()

class fill:
    def __init__(self):
        self.currentlySyncing = False
    
def syncWithDatabase(self):
    import sqlite3
    
    if self.currentlySyncing:
        return
    try:
        self.currentlySyncing = True
        onlineDbConnection = pymysql.connect(host='coderedscout.heliohost.org', user='codered_user1', password='codered2019',
                                         db='codered_scouting', charset='utf8mb4')
        
