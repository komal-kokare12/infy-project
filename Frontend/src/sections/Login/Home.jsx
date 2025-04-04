import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../Components/Home.css';

const Home = () => {
  const navigate = useNavigate();

  const userEmail = localStorage.getItem('userEmail');
  const userRole = localStorage.getItem('userRole');
  const storedUserData = JSON.parse(localStorage.getItem('userData'));

  useEffect(() => {
    if (!userEmail || !userRole || !storedUserData) {
      navigate('/login'); // Redirect if no user is logged in
    }
  }, []);

  return (
    <div className="home_container">
      <h2>Welcome, {storedUserData?.name}!</h2>
      <p><strong>Email:</strong> {userEmail}</p>
      <p><strong>Role:</strong> {userRole}</p>
      <p><strong>Phone:</strong> {storedUserData?.phone}</p>
      <p><strong>Society ID:</strong> {storedUserData?.societyId}</p>
      <p><strong>Society Name:</strong> {storedUserData?.societyName}</p>

      {userRole === 'Admin' ? (
        <div className="admin_details">
          <h3>Admin Profile</h3>
          <p><strong>Society Address:</strong> {storedUserData?.societyAddress}</p>
          <p><strong>City:</strong> {storedUserData?.city}</p>
          <p><strong>District:</strong> {storedUserData?.district}</p>
          <p><strong>Postal Code:</strong> {storedUserData?.postal}</p>
        </div>
      ) : (
        <div className="resident_details">
          <h3>Resident Profile</h3>
          <p><strong>Flat No:</strong> {storedUserData?.flatNo}</p>
          <p><strong>Postal Code:</strong> {storedUserData?.postal}</p>
        </div>
      )}
    </div>
  );
};

export default Home;
