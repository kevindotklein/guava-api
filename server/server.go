package server

import (
	"log"

	"github.com/gin-gonic/gin"
	"github.com/kevindotklein/guava-api/config"
	"github.com/kevindotklein/guava-api/server/routes"
)

type Server struct {
	port   string
	server *gin.Engine
}

func NewServer() Server {
    return Server{
        port: config.GetEnv("APP_PORT", "5000"),
        server: gin.Default(),
    }
}

func (s *Server) Run() {
    router := routes.ConfigRoutes(s.server)

    log.Print("running at port: ", s.port)
    log.Fatal(router.Run(":" + s.port))
}