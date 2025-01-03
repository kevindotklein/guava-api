package services

import (
	"github.com/gin-gonic/gin"
	"github.com/google/uuid"
	"github.com/kevindotklein/guava-api/db"
	"github.com/kevindotklein/guava-api/models"
)

func CreateUserService(c *gin.Context) {
	var user models.User

	err := c.ShouldBindBodyWithJSON(&user)
	if err != nil {
		c.JSON(400, gin.H{
			"error": "invalid body, could not parse into json",
		})
		return
	}

	db := db.GetDatabase()

	user.Password = SHA256Encoder(user.Password)

	err = db.Create(&user).Error
	if err != nil {
		c.JSON(400, gin.H{
			"error": "could not create post",
		})
		return
	}

	c.JSON(201, user)
}

func GetUserService(c *gin.Context, strId string) {
	id, err := uuid.Parse(strId)
	if err != nil {
		c.JSON(400, gin.H{
			"error": "invalid id",
		})
		return
	}

	var user models.User

	db := db.GetDatabase()
	err = db.First(&user, id).Error
	if err != nil {
		c.JSON(400, gin.H{
			"error": "cannot find user",
		})
		return
	}

	c.JSON(200, user)

}

func GetUsersService(c *gin.Context) {
	db := db.GetDatabase()
	
	var users []models.User
	err := db.Find(&users).Error
	if err != nil {
		c.JSON(400, gin.H{
			"error": "could not list users",
		})
		return
	}

	c.JSON(200, users)
}