package routes

import (
	"github.com/gin-gonic/gin"
	"github.com/kevindotklein/guava-api/handlers"
)

func ConfigRoutes(router *gin.Engine) *gin.Engine {
	main := router.Group("api/v1")
	{
		posts := main.Group("posts")
		{
      posts.GET("/:id", handlers.GetPost)
			posts.GET("/", handlers.GetPosts)
			posts.POST("/", handlers.CreatePost)
		}
		users := main.Group("users")
		{
			users.POST("/", handlers.CreateUser)
			users.GET("/", handlers.GetUsers)
			users.GET("/:id", handlers.GetUser)
		}
	}

	return router
}