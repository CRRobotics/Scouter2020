def commitToDatabase(data)
    import sqlite3
    
    conn = sqlite3.connect(database.db)
    cur = conn.cursor()
    
    cur.execute("CREATE TABLE IF NOT EXISTS data_table (matchNumber INTEGER, team INTEGER, crossing BOOLEAN, lowhigh_auto INTEGER, \
    reachCapacity BOOLEAN, low INTEGER, high INTEGER, spin BOOLEAN, climb BOOLEAN, capacity BOOLEAN)")
    
    local_data = "INSERT INTO data_table (matchNumber, team, crossing, low, high, reachCapacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
    local_backup = "INSERT INTO data_table (matchNumber, team, crossing, low, high, reachCapacity, lowhigh, spin, climb, capacity) \
                  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                   
    cur.execute(local_data, data)
    conn.commit()
    for row in cursor:
        print(row)
    
    cursor.close()

class fill:
    def __init__(self):
        self.currentlySyncing = False
    
def syncWithDatabase(self):
    import pymysql
    import sqlite3
    
    if self.currentlySyncing:
        return
    try:
        self.currentlySyncing = True
        onlineDbConnection = pymysql.connect(host='coderedscout.heliohost.org', user='codered_user1', password='codered2019', \
        db='codered_scouting', charset='utf8mb4', email='ryancunningham@icsd.k12.ny.us')
        onlineDB = onlineDbConnection = pymysql.cursor()
        initializeOnlineDB = "CREATE TABLE IF NOT EXISTS data(" \
            (crossing BOOLEAN, lowhigh_auto INTEGER, \
            matchNumber, team, reachCapacity BOOLEAN, low INTEGER, high INTEGER, spin BOOLEAN, climb BOOLEAN, capacity BOOLEAN)")
            
        onlineDb.execute(initializeOnlineDB)
        conn = sqlite3.connect("database.db")
        localDB = conn.cursor()
        localDB.execute("SELECT * FROM data")
        allData = localDB.fetchall()
        addDataToOnlineDB = "INSERT INTO data(matchNumber, team, canAutoCross, autoCargo, autoHatchPanels, autoStartLevel, " \
              "cargoBay, cargoRocket, hatchPanelsBay, hatchPanelsRocket, canLowGoal, canHighGoal, tendency, climbTime, climbLevel, defense, matchNotes)" \
              "VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
