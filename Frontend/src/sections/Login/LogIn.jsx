
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './LogIn.css';
import buildingImage from './assets/building pic for sign up page.jpg';
import CommunityLogo from './assets/Logo.jpg';
import { Link } from 'react-router-dom';

const LogIn = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState('');

  const handleLogin = async (e) => {
    e.preventDefault();
    console.log("Login button clicked");

    const user = { email, password, role };
    console.log("User Data:", user);

    try {
      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user),
      });

      console.log("Response Status:", response.status);

      if (!response.ok) {
        const errorText = await response.text();
        console.error("Login Failed:", errorText);
        alert(`Login Failed: ${errorText}`);
        return;
      }

      const data = await response.json();
      console.log("Response Data:", data);

      // Store user details in localStorage
      localStorage.setItem('userEmail', email);
      localStorage.setItem('userRole', data.role);
      localStorage.setItem('userData', JSON.stringify(data.adminDetails || data.residentDetails));

      // Redirect based on role
      if (data.role === 'Admin') {
        navigate('/homeAdmin');
      } else if (data.role === 'Resident') {
        navigate('/homeResident');
      }
    } catch (error) {
      console.error('Login Error:', error);
      alert("An error occurred. Check console logs.");
    }
  };

  return (
    <div className="login-page-container">
      <div className="login_section">
        <div className="login_img">
          <img src={buildingImage} alt="building" />
        </div>
        <div className="login_form">
          <img src={CommunityLogo} id="logo" alt="community logo" />
          <h3>Log In</h3>
          <form onSubmit={handleLogin}>
            <label>Email</label>
            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            <br /><br />

            <label>Password</label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
            <br /><br />

            <label>Role</label>
            <select value={role} onChange={(e) => setRole(e.target.value)} required>
              <option value="" disabled>Select Role</option>
              <option value="Admin">Admin</option>
              <option value="Resident">Resident</option>
            </select>
            <br /><br />

            <input type="submit" className="button" value="Log In" />
          </form>

          <p className="signup_prompt">
            Don't have an account? <Link to="/signup">Sign Up</Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default LogIn;