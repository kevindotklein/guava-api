package handlers

import (
	"github.com/gin-gonic/gin"
	"github.com/google/uuid"
	"github.com/kevindotklein/guava-api/db"
	"github.com/kevindotklein/guava-api/models"
)

func GetPost(c *gin.Context) {
	strId := c.Param("id")

	id, err := uuid.Parse(strId)
	if err != nil {
		c.JSON(400, gin.H{
			"error": "invalid id",
		})
		return 
	}

	db := db.GetDatabase()

	var post models.Post
	err = db.First(&post, id).Error
	if err != nil {
		c.JSON(400, gin.H{
			"error": "cannot find post",
		})
		return
	}

	c.JSON(200, post)
}


func CreatePost(c *gin.Context) {
	db := db.GetDatabase()

	var post models.Post

	err := c.ShouldBindBodyWithJSON(&post)
	if err != nil {
		c.JSON(400, gin.H{
			"error": "invalid body, could not parse into json",
		})
		return
	}

	err = db.Create(&post).Error
	if err != nil {
		c.JSON(400, gin.H{
			"error": "could not create post",
		})
		return
	}

	c.JSON(200, post)
}

func GetPosts(c *gin.Context) {
	db := db.GetDatabase()

	var posts []models.Post
	err := db.Find(&posts).Error
	if err != nil {
		c.JSON(400, gin.H{
			"error": "could not list posts",
		})
		return
	}

	c.JSON(200, posts)
}