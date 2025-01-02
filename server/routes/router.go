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
	}

	return router
}