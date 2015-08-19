/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.linyuxing;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public final class Constants {

	public static final String[] IMAGES = new String[] {
			// Heavy images
			"http://img1.qunarzz.com/travel/d2/201401/22/d7929a6b29b4def0ddb12cfb.jpg", "http://img1.qunarzz.com/travel/d6/201407/01/75a1afe123cad200ddb12cfb.jpg_r_1024x683_825e0211.jpg",
			"http://img1.qunarzz.com/travel/poi/201406/10/e13c69ae2a6cba65ddb12cfb.jpg", "http://img1.qunarzz.com/travel/poi/201403/29/c0e8bdfd27194a47ddb12cfb.jpg",
			"http://img1.qunarzz.com/travel/poi/201405/20/0de5f98c284f46bdddb12cfb.jpg", "http://img1.qunarzz.com/travel/d4/1409/10/72ec265fcfb8a8eaffffffffc8d65eac.jpg",
			"http://img1.qunarzz.com/travel/d5/1409/17/422d478fccc54838ffffffffc8d65eac.jpeg_r_1024x683x95_bc843cae.jpeg",
			"http://img1.qunarzz.com/travel/d4/1411/1f/1f06b3d93aee79df213a9cdb.jpg_r_1024x683x95_82032c7c.jpg", "http://img1.qunarzz.com/travel/d8/1505/72/39e2075022e7b5.jpg",
			"http://img1.qunarzz.com/travel/poi/1504/16/0f9fa7366f25c3.jpg" };

	public static final String[] RECOMMENDIMAGE = new String[] { "http://img1.qunarzz.com/travel/d0/1408/28/ec37c21593f64f25ffffffffc8d65eac.jpg",
			"http://img1.qunarzz.com/travel/d2/1502/58/01c9ce916fb59a.jpg", "http://img1.qunarzz.com/travel/d3/1505/2a/03a0c61daf13e6.jpg",
			"http://hiphotos.baidu.com/lvpics/pic/item/eac4b74543a9822607ab29f28a82b9014b90ebf9.jpg" };

	private Constants() {
	}

	public static class Config {
		public static final boolean DEVELOPER_MODE = false;
	}

	public static class Extra {
		public static final String FRAGMENT_INDEX = "com.nostra13.example.universalimageloader.FRAGMENT_INDEX";
		public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
	}
}
