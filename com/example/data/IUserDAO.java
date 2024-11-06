/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.data;

/**
 *
 * @author Khaid
 */

 public interface IUserDAO {
    int getUserFine(String userId);
    void updateUserFine(String userId, int fineAmount);
}
