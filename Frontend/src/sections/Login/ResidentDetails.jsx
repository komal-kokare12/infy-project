import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './FormStyle.css';
import buildingImage from './assets/building pic for sign up page.jpg';
import CommunityLogo from './assets/Logo.jpg';

const ResidentDetails = () => {
    const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [details, setDetails] = useState({
        name: '', phone: '', societyId: '', societyName: '', flatNo: '', block: '', postal: '',
    });

    useEffect(() => {
        const storedEmail = localStorage.getItem("userEmail");
        if (storedEmail) {
            setEmail(storedEmail);
        } else {
            console.error("Email not found in localStorage.");
        }
    }, []);

    const handleChange = (e) => {
        setDetails({ ...details, [e.target.name]: e.target.value });
    };

    const handleRegister = async () => {
        if (!email) {
            console.error("Email not found.");
            return;
        }

        try {
            const response = await fetch(`http://localhost:8080/api/user/resident-details?email=${email}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(details),
            });

            if (response.ok) {
                console.log("Resident details saved successfully");
                navigate('/success');
            } else {
                console.error("Error saving resident details");
            }
        } catch (error) {
            console.error("Error:", error);
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
                    <h3>Resident Details</h3>
                    <p className="email-display">Email: {email ? email : "Loading..."}</p>

                    <form>
                        <label>Name</label>
                        <input type="text" name="name" value={details.name} onChange={handleChange} required />
                        
                        <label>Phone Number</label>
                        <input type="text" name="phone" value={details.phone} onChange={handleChange} required />
                        
                        <label>Society ID</label>
                        <input type="text" name="societyId" value={details.societyId} onChange={handleChange} required />
                        
                        <label>Society Name</label>
                        <input type="text" name="societyName" value={details.societyName} onChange={handleChange} required />
                        
                        <label>Block</label>
                        <input type="text" name="block" value={details.block} onChange={handleChange} required />
                        
                        <label>Flat No.</label>
                        <input type="text" name="flatNo" value={details.flatNo} onChange={handleChange} required />
                        
                        <label>Postal Code</label>
                        <input type="text" name="postal" value={details.postal} onChange={handleChange} required />

                        <input type="button" className="button" onClick={handleRegister} value="Register" />
                    </form>
                </div>
            </div>
        </div>
    );
};

export default ResidentDetails;