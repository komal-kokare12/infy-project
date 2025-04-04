import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import './SignUp.css';
import buildingImage from './assets/building pic for sign up page.jpg';
import CommunityLogo from './assets/Logo.jpg';

const SignUp = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('Resident');
    const navigate = useNavigate();

    const handleSignUp = async (e) => {
        e.preventDefault(); // Prevents page reload

        const user = { email, password, role };
        console.log("Sending data to backend:", user);

        try {
            const response = await fetch('http://localhost:8080/auth/signup', {
                method: 'POST',
                headers: { 
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(user),
            });

            console.log("Raw response:", response);

            // First check if response is ok
            if (!response.ok) {
                const errorData = await response.json().catch(() => ({}));
                console.error("Signup failed:", errorData.message || response.statusText);
                alert(`Signup failed: ${errorData.message || response.statusText}`);
                return;
            }

            const data = await response.json();
            console.log("Response data:", data);

            if (response.ok) {
                console.log("Signup successful! Redirecting...");
                localStorage.setItem("userEmail", email); // Store email in localStorage

                if (role === 'Resident') {
                    navigate('/resident-details');
                } else {
                    navigate('/admin-details');
                }
            }
        } catch (error) {
            console.error("Error connecting to backend:", error);
            alert("An error occurred. Please check console for details.");
        }
    };

    return (
        <div className="signup-page-container">
            <div className="signup_section">
                <div className="signup_img">
                    <img src={buildingImage} alt="building" />
                </div>
                <div className="signup_form">
                    <img src={CommunityLogo} id="logo" alt="community logo" />
                    <h3>Sign Up</h3>

                    <form onSubmit={handleSignUp}>
                        <label>Email</label>
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                        <br /><br />

                        <label>Password</label>
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                        <br /><br />

                        <label>Role</label>
                        <select 
                            value={role} 
                            onChange={(e) => setRole(e.target.value)}
                            required
                        >
                            <option value="Admin">Admin</option>
                            <option value="Resident">Resident</option>
                        </select>
                        <br /><br />

                        <button type="submit" className="button">
                            Sign Up
                        </button>
                    </form>
                    <p className="signup_prompt">
                        Already have an account? <Link to="/login">Log In</Link>
                    </p>
                </div>
            </div>
        </div>
    );
};

export default SignUp;