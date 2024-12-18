package main

import (
	"github.com/kevindotklein/guava-api/db"
	"github.com/kevindotklein/guava-api/db/migrations"
	"github.com/kevindotklein/guava-api/server"
)

func main() {
	db.StartDB()
	database := db.GetDatabase()
	migrations.RunMigrations(database)
	server := server.NewServer()


	server.Run()
}