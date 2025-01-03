package handlers

import (
	"github.com/gin-gonic/gin"
	"github.com/kevindotklein/guava-api/services"
)

func CreateUser(c *gin.Context) {
	services.CreateUserService(c)
}

func GetUser(c *gin.Context) {
	strId := c.Param("id")
	services.GetUserService(c, strId)
}

func GetUsers(c *gin.Context) {
	services.GetUsersService(c)
}