package handlers

import (
	"github.com/gin-gonic/gin"
	"github.com/kevindotklein/guava-api/services"
)

func GetPost(c *gin.Context) {
	strId := c.Param("id")
	services.GetPostService(c, strId)
}


func CreatePost(c *gin.Context) {
	services.CreatePostService(c)	
}

func GetPosts(c *gin.Context) {
	services.GetPostsService(c)
}