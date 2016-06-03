package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Static class that adds and retrieves images from resource folder
 */
public final class ImageStorage {

	private static final String IMAGE_STORAGE_LOCATION = "res\\img";
	private static final String DEFAULT_AVATAR_PATH = IMAGE_STORAGE_LOCATION + "\\defaultAvatar.png";
	private static final String DEFAULT_PHONE_PHOTO_PATH = IMAGE_STORAGE_LOCATION + "\\defaultPhonePhoto.png";

	/**
	 * Retrieves avatar from storage location
	 * @param avatarPath Path to avatar in storage
	 * @return Avatar as buffered image
	 * @throws IOException
	 */
	public static BufferedImage getBufferedAvatar(String avatarPath) throws IOException {
		if (avatarPath == null) {
			return ImageIO.read(new File(DEFAULT_AVATAR_PATH));
		}

		File avatarFile = new File(avatarPath);
		if (!avatarFile.isFile()) {
			throw new IllegalArgumentException("Given avatar path is not valid");
		}

		return ImageIO.read(avatarFile);
	}

	/**
	 * Retrieves avatar from storage location
	 * @param avatarPath Path to avatar in storage
	 * @return Avatar as array of bytes
	 * @throws IOException
	 */
	public static byte[] getAvatar(String avatarPath) throws IOException {
		BufferedImage image = getBufferedAvatar(avatarPath);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);

		return baos.toByteArray();
	}

	/**
	 * Adds avatar to the storage, overwrites if already exits
	 * @param username Needed for directory creation
	 * @param avatar Buffered image needed to be stored
	 * @return Path to the avatar in storage
	 * @throws IOException
	 */
	public static String addBufferedAvatar(String username, BufferedImage avatar) throws IOException {
		String userPathString = IMAGE_STORAGE_LOCATION + "\\" + username;

		// Check if user folder exists, if doesn't create
		Path userPath = Paths.get(userPathString);
		if (Files.notExists(userPath)) {
			File userDir = new File(userPathString);
			if (!userDir.mkdir()) {
				throw new IllegalArgumentException("Cannot create dir for user " + username);
			}
		}

		// Save image
		String avatarPath = userPathString + "\\avatar.png";
		ImageIO.write(avatar, "png", new File(avatarPath));

		return avatarPath;
	}

	/**
	 * Adds avatar to the storage, overwrites if already exits
	 * @param username Needed for directory creation
	 * @param avatar Avatar as byte array needed to be stored
	 * @return Path to the avatar in storage
	 * @throws IOException
	 */
	public static String addAvatar(String username, byte[] avatar) throws IOException {
		return addBufferedAvatar(username, ImageIO.read(new ByteArrayInputStream(avatar)));
	}

	/**
	 * Retrieves photos from storage
	 * @param phonePhotosDirPath Path to directory which contains all of the relevant photos
	 * @return List of photos as buffered images
	 * @throws IOException
	 */
	public static List<BufferedImage> getBufferedPhonePhotos(String phonePhotosDirPath) throws IOException {
		List<BufferedImage> photos = new ArrayList<>();

		if (phonePhotosDirPath == null) {
			photos.add(ImageIO.read(new File(DEFAULT_PHONE_PHOTO_PATH)));
			return photos;
		}

		File photosDir = new File(phonePhotosDirPath);
		if (!photosDir.isDirectory()) {
			throw new IllegalArgumentException("Given directory path is not valid");
		}

		String[] photoFiles = photosDir.list();
		for (String photoFile : photoFiles) {
			if (photoFile.endsWith(".png")){
				photos.add(ImageIO.read(new File(phonePhotosDirPath + "\\" + photoFile)));
			}
		}

		return photos;
	}

	/**
	 * Retrieves photos from storage
	 * @param phonePhotosDirPath Path to directory which contains all of the relevant photos
	 * @return List of photos as byte arrays
	 * @throws IOException
	 */
	public static List<byte[]> getPhonePhotos(String phonePhotosDirPath) throws IOException {
		List<BufferedImage> photos = getBufferedPhonePhotos(phonePhotosDirPath);
		List<byte[]> photosAsBytes = new ArrayList<>();

		for (BufferedImage photo : photos) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(photo, "png", baos);

			photosAsBytes.add(baos.toByteArray());
		}

		return photosAsBytes;
	}

	/**
	 * Adds photos to the storage. This can be done only once, during ad creation,
	 * thus any other attempt to add photos of the same phone in the same ad will be impossible
	 * @param username Needed for folder creation
	 * @param adId Needed for folder creation
	 * @param photos List of buffered images needed to be stored
	 * @return Path to the folder containing all the photos of this ad
	 * @throws IOException
	 */
	public static String addBufferedPhonePhotos(String username, String adId, List<BufferedImage> photos) throws IOException {
		String adDirString = IMAGE_STORAGE_LOCATION + "\\" + username + "\\" + adId;

		// Check if ad folder exists, if doesn't create
		Path adPath = Paths.get(adDirString);
		if (Files.notExists(adPath)) {
			File adDir = new File(adDirString);
			if (!adDir.mkdir()) {
				throw new IllegalArgumentException("Cannot create folder for user " + username + " and ad " + adId);
			}
		}
		else {
			throw new IllegalArgumentException("Directory [" + adDirString + "] already exists");
		}

		// Save all the photos
		int counter = 0;
		for (BufferedImage photo : photos) {
			String photoPath = adDirString + "\\" + counter++ + ".png";
			ImageIO.write(photo, "png", new File(photoPath));
		}

		return adDirString;
	}

	/**
	 * Adds photos to the storage. This can be done only once, during ad creation,
	 * thus any other attempt to add photos of the same phone in the same ad will be impossible
	 * @param username Needed for folder creation
	 * @param adId Needed for folder creation
	 * @param photos List of byte array photos needed to be stored
	 * @return Path to the folder containing all the photos of this ad
	 * @throws IOException
	 */
	public static String addPhonePhotos(String username, String adId, List<byte[]> photos) throws IOException {
		List<BufferedImage> bufferedPhotos = new ArrayList<>();

		for (byte[] photo : photos) {
			bufferedPhotos.add(ImageIO.read(new ByteArrayInputStream(photo)));
		}

		return addBufferedPhonePhotos(username, adId, bufferedPhotos);
	}
}
